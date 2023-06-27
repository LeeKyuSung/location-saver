#!/bin/bash

kill $(cat /home/leekyusung/location-saver/pid.file) && rm /home/leekyusung/location-saver/pid.file | true

nohup ./start.sh &