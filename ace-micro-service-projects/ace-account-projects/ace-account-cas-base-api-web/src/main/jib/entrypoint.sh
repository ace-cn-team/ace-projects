#!/bin/sh

#echo -e "\nChecking java..."
#java -version

#echo -e "\nCreating CAS configuration directories..."
mkdir -p /etc/cas/config
mkdir -p /etc/cas/services

#echo "Listing provided CAS docker artifacts..."
#ls -R docker/cas

#echo -e "\nMoving CAS configuration artifacts..."
mv docker/cas/thekeystore /etc/cas 2>/dev/null
mv docker/cas/config/*.* /etc/cas/config 2>/dev/null
mv docker/cas/services/*.* /etc/cas/services 2>/dev/null

#echo -e "\nListing CAS configuration under /etc/cas..."
#ls -R /etc/cas

echo -e "\nRunning CAS..."
exec java -Xms1G -Xmx2G -XX:+TieredCompilation -XX:TieredStopAtLevel=1 -jar docker/war/ace-account-base-cas-api-web.war
