if [ ! -x "./mongo-feeder/target/mongofeeder-0.0.1-SNAPSHOT.jar" ]
then
     cd reactive-commons
     mvn clean install
     cd ../mongo-feeder
     mvn clean package
     cd ..
     chmod +x  ./mongo-feeder/target/mongofeeder-0.0.1-SNAPSHOT.jar
fi
 
java -jar ./mongo-feeder/target/mongofeeder-0.0.1-SNAPSHOT.jar
