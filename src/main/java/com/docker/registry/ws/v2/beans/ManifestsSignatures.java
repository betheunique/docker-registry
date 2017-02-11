package com.docker.registry.ws.v2.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author abhishekrai
 * @since 10/02/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ManifestsSignatures {

    private String signature;
    private Header header;

    private static class Header {
        private String alg;
        private Jwk jwk;

        private static class Jwk {
            String crv;
            private String kid;
            private String kty;
            private String x;
            private String y;

            public String getCrv() {
                return crv;
            }

            public void setCrv(String crv) {
                this.crv = crv;
            }

            public String getKid() {
                return kid;
            }

            public void setKid(String kid) {
                this.kid = kid;
            }

            public String getKty() {
                return kty;
            }

            public void setKty(String kty) {
                this.kty = kty;
            }

            public String getX() {
                return x;
            }

            public void setX(String x) {
                this.x = x;
            }

            public String getY() {
                return y;
            }

            public void setY(String y) {
                this.y = y;
            }

            @Override
            public String toString() {
                return "Jwk{" +
                        "crv='" + crv + '\'' +
                        ", kid='" + kid + '\'' +
                        ", kty='" + kty + '\'' +
                        ", x='" + x + '\'' +
                        ", y='" + y + '\'' +
                        '}';
            }
        }

        public Jwk getJwk() {
            return jwk;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }

        public String getAlg() {
            return alg;
        }

        public void setJwk(Jwk jwk) {
            this.jwk = jwk;
        }

        @Override
        public String toString() {
            return "Header{" +
                    "alg='" + alg + '\'' +
                    ", jwk=" + jwk +
                    '}';
        }
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "ManifestsSignatures{" +
                "signature='" + signature + '\'' +
                ", header=" + header +
                '}';
    }
}
