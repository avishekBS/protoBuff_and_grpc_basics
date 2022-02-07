## CREATE BASIC PROJECT on PROTOBUFFER

**Datatype conversion in java:
1) int32, int64, float, double   --> int, long float, double
2) bool --> boolean
3) enum --> enum
4) Lists --> java.util.list
5) Map --> java.util.Map
6) nested class



## create GRPC project

**steps:
1) create the proto file and define the rpc service
2) create service class which extends the proto service name ImplBase
3) create a server
4) now to consume service implement client in java