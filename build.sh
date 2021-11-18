docker build -t aakansha_java:1.0 .

mvn clean install
docker build -t aakansha_java:1.0 -t anku518/aakansha_java:1.0.1 .
docker push anku518/aakansha_java:1.0.1