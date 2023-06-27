#!/bin/bash
java -jar build/libs/location-saver-1.0.0.jar --spring.profiles.active=prod & echo $! > /home/leekyusung/location-saver/pid.file &