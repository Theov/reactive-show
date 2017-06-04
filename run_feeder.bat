cd reactive-commons
mvn clean install
cd ../mongo-feeder
mvn clean package
cd ..

java -jar ./mongo-feeder/target/mongofeeder-0.0.1-SNAPSHOT.jar
