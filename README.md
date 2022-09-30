# A Java SOAP Web Service


# Prerequisites

1. [Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 8+
2. [Maven](https://maven.apache.org) 3+


# How to run

### Clone

```
git clone git@github.com:s1ga/web-services.git
git checkout feature/soap-service
```

### Inside



```
cd web-services
```

### Run

```
mvn package
mvn embedded-glassfish:run -Dhttp.port=4141
```

### Endpoint

[http://localhost:8080/FridgeEndpointService](http://localhost:8080/FridgeEndpointService)

### WSDL

[http://localhost:8080/FridgeEndpointService?wsdl](http://localhost:8080/FridgeEndpointService?wsdl)

# References

[Maven plugin for GlassFish](https://jinahya.wordpress.com/2015/04/23/using-maven-embedded-glassfish-plugin-4-x/)
