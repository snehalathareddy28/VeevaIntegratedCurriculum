
import java.util.*;
import java.util.stream.Collectors;

public class StreamQuestion3 {

    // Patient class
    static class Patient {

        int patientId;
        String patientName;
        String dept;
        String doctorName;
        String diagnosis;
        String treatmentGiven;
        String patientType;
        int heartbeat;
        int bp;
        int sugarValue;
        String severity;

        // Constructor
        Patient(int patientId, String patientName, String dept,
                String doctorName, String diagnosis,
                String treatmentGiven, String patientType,
                int heartbeat, int bp, int sugarValue,
                String severity) {

            this.patientId = patientId;
            this.patientName = patientName;
            this.dept = dept;
            this.doctorName = doctorName;
            this.diagnosis = diagnosis;
            this.treatmentGiven = treatmentGiven;
            this.patientType = patientType;
            this.heartbeat = heartbeat;
            this.bp = bp;
            this.sugarValue = sugarValue;
            this.severity = severity;
        }

        // Getters
        public String getPatientType() {
            return patientType;
        }

        public int getHeartbeat() {
            return heartbeat;
        }

        // Convert Patient object into readable text
        @Override
        public String toString() {
            return patientName + " - " + patientType
                    + " - Heartbeat: " + heartbeat
                    + " - Severity: " + severity;
        }
    }

    public static void main(String[] args) {

        // Creating patient records
        List<Patient> patients = Arrays.asList(

                new Patient(1, "Sneha", "Cardiology",
                        "Dr.Ravi", "Heart Problem", "Medication",
                        "ICU", 120, 140, 110, "High"),

                new Patient(2, "Priya", "General",
                        "Dr.Kiran", "Fever", "Medicine",
                        "Outpatient", 80, 120, 100, "Low"),

                new Patient(3, "Arun", "Cardiology",
                        "Dr.Ravi", "Heart Attack", "Surgery",
                        "ICU", 130, 150, 160, "Critical"),

                new Patient(4, "John", "General",
                        "Dr.Kiran", "Infection", "Antibiotics",
                        "Inpatient", 90, 130, 120, "Medium")
        );

        // 1. Find all ICU patients
        System.out.println("1. ICU PATIENTS");

        List<Patient> icuPatients = patients.stream()
                .filter(patient ->
                        patient.getPatientType().equals("ICU"))
                .collect(Collectors.toList());

        icuPatients.forEach(System.out::println);


        // 2. Find ICU patients with heartbeat greater than 100
        System.out.println("\n2. ICU PATIENTS WITH HEARTBEAT > 100");

        List<Patient> highHeartbeat = patients.stream()
                .filter(patient ->
                        patient.getPatientType().equals("ICU")
                                && patient.getHeartbeat() > 100)
                .collect(Collectors.toList());

        highHeartbeat.forEach(System.out::println);


        // 3. Sort all patients by severity
        System.out.println("\n3. PATIENTS SORTED BY SEVERITY");

        List<Patient> sortedPatients = patients.stream()
                .sorted(Comparator.comparingInt(patient -> {
                    switch (patient.severity) {
                        case "Low":
                            return 1;
                        case "Medium":
                            return 2;
                        case "High":
                            return 3;
                        case "Critical":
                            return 4;
                        default:
                            return 5;
                    }
                }))
                .collect(Collectors.toList());

        sortedPatients.forEach(System.out::println);
    }
}
