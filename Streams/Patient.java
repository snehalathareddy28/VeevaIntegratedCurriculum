class Patient {

    int patientId;
    String patientName;
    String patientType;
    int heartbeat;
    String severity;

    Patient(int patientId, String patientName,
            String patientType, int heartbeat,
            String severity) {

        this.patientId = patientId;
        this.patientName = patientName;
        this.patientType = patientType;
        this.heartbeat = heartbeat;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return patientName + " - " + patientType
                + " - Heartbeat: " + heartbeat
                + " - Severity: " + severity;
    }
}