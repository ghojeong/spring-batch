URL=????.org
KEY=/Users/pyro/.ssh/keys/????.pem
JAR=./build/libs/batch.jar
SERVER="ubuntu@$URL:~/batch/"

./gradlew build && scp -i $KEY $JAR $SERVER
