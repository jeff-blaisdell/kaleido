#!/bin/bash
working_dir=$(pwd)
project_dir=/www/stage/kaleido
cd $project_dir

echo "Feching git changes..."
git fetch

echo "Merging git changes..."
git merge origin/master

echo "Cleaning project target directory..."
rm -rf $project_dir/target

echo "Building WAR..."
grails war

echo "Staging to k.war"
cp ./target/k-0.1.war ./target/k.war

echo "Stopping Tomcat..."
sudo /etc/init.d/tomcat-kaleido-alpha stop

echo "Cleaning Tomcat Directories..."
rm -rf /www/sites/alpha/tomcat-kaleido/webapps/k
rm -f /www/sites/alpha/tomcat-kaleido/webapps/k.war

echo "Deploying WAR..."
cp ./target/k.war /www/sites/alpha/tomcat-kaleido/webapps/k.war

echo "Starting Tomcat..."
sudo /etc/init.d/tomcat-kaleido-alpha start

echo "Success!"