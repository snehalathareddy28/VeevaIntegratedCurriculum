package InventorySalesSystem;

public class Company {

        private String companyId;
        private String companyName;
        private String contactDetails;
        private String location;

        public Company(String companyId, String companyName,
                       String contactDetails, String location) {

            this.companyId = companyId;
            this.companyName = companyName;
            this.contactDetails = contactDetails;
            this.location = location;
        }

        public String getCompanyId() {
            return companyId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public String getContactDetails() {
            return contactDetails;
        }

        public String getLocation() {
            return location;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public void setContactDetails(String contactDetails) {
            this.contactDetails = contactDetails;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        @Override
        public String toString() {
            return "Company ID: " + companyId
                    + ", Name: " + companyName
                    + ", Contact: " + contactDetails
                    + ", Location: " + location;
        }
    }

