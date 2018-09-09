package com.osteck.troubles.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("api")
public class ApiInformation {
    private String version;
    private String name;
    private String license;
    private String licenseUrl;

    private Formatting formatting = new Formatting();
    private Contact contact = new Contact();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicenseUrl() {
        return licenseUrl;
    }

    public void setLicenseUrl(String licenceUrl) {
        this.licenseUrl = licenceUrl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Formatting getFormatting() {
        return formatting;
    }

    public Contact getContact() {
        return contact;
    }

    public static class Formatting {
        private String basePath;

        public String getBasePath() {
            return basePath;
        }

        public void setBasePath(String basePath) {
            this.basePath = basePath;
        }
    }

    public static class Contact {
        private String email;
        private String name;
        private String url;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Swagger {
        private String paths;

        public String getPaths() {
            return paths;
        }

        public void setPaths(String paths) {
            this.paths = paths;
        }
    }

    String basePath(){
        return String.format(getFormatting().getBasePath(), getVersion());
    }
}