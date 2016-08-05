### Run ginie
-  mvn clean package
-  java -jar target/ginie-1.0-SNAPSHOT-jar-with-dependencies.jar -c ../conf/ginie.conf.yml -l ../conf/ginie.logback.xml
   
    
    
### Regarding APIS
Content-type application/json all

## save
- post

http://0.0.0.0:8080/save
- request
```json
{
	"ip": "172.16.1.50",
	"port": "9100",
	"url": "htt://172.16.1.51/testmenot",
	"logPath": "/disk2/test.log",
	"status": "enabled",
	"tags": ["testtag3", "testtag4"]
}
```



## list
 - get

http://0.0.0.0:8080/list
- result
```json
[
    {
        "port": "9300",
        "logPath": "/disk2/test.log",
        "IP": "172.16.1.51",
        "_id": {
            "date": "Fri Aug 05 22:11:37 IST 2016",
            "currentCounter": -2145418680,
            "generatedMachineIdentifier": 1948707,
            "machineIdentifier": 1948707,
            "generatedProcessIdentifier": 21418,
            "time": 1470415297000,
            "processIdentifier": 14206,
            "counter": 9702718,
            "timestamp": 1470415297,
            "timeSecond": 1470415297
        },
        "url": "htt://172.16.1.51/testme",
        "tags": [
            "testtag",
            "testtag2"
        ],
        "status": "enabled"
    },
    {
        "port": "9100",
        "logPath": "/disk2/test.log",
        "IP": "172.16.1.50",
        "_id": {
            "date": "Sat Aug 06 00:53:43 IST 2016",
            "currentCounter": -2145418680,
            "generatedMachineIdentifier": 1948707,
            "machineIdentifier": 1948707,
            "generatedProcessIdentifier": 21418,
            "time": 1470425023000,
            "processIdentifier": 19905,
            "counter": 4559679,
            "timestamp": 1470425023,
            "timeSecond": 1470425023
        },
        "url": "htt://172.16.1.51/testmenot",
        "tags": [
            "testtag3",
            "testtag4"
        ],
        "status": "enabled"
    },
    {
        "port": "9100",
        "logPath": "/disk2/test.log",
        "IP": "172.16.1.50",
        "_id": {
            "date": "Sat Aug 06 00:54:13 IST 2016",
            "currentCounter": -2145418680,
            "generatedMachineIdentifier": 1948707,
            "machineIdentifier": 1948707,
            "generatedProcessIdentifier": 21418,
            "time": 1470425053000,
            "processIdentifier": 21418,
            "counter": 2064967,
            "timestamp": 1470425053,
            "timeSecond": 1470425053
        },
        "url": "htt://172.16.1.51/testmenot",
        "tags": [
            "testtag3",
            "testtag4"
        ],
        "status": "enabled"
    }
]
```


## findby Tag
- post

http://0.0.0.0:8080/find

- request 
```json
{
	"tags": ["testtag2", "testtag4"]
}
```

- result
```json
[
    {
        "port": "9300",
        "logPath": "/disk2/test.log",
        "IP": "172.16.1.51",
        "_id": {
            "date": "Fri Aug 05 22:11:37 IST 2016",
            "currentCounter": -2145418680,
            "generatedMachineIdentifier": 1948707,
            "machineIdentifier": 1948707,
            "generatedProcessIdentifier": 21418,
            "time": 1470415297000,
            "processIdentifier": 14206,
            "counter": 9702718,
            "timestamp": 1470415297,
            "timeSecond": 1470415297
        },
        "url": "htt://172.16.1.51/testme",
        "tags": [
            "testtag",
            "testtag2"
        ],
        "status": "enabled"
    },
    {
        "port": "9100",
        "logPath": "/disk2/test.log",
        "IP": "172.16.1.50",
        "_id": {
            "date": "Sat Aug 06 00:53:43 IST 2016",
            "currentCounter": -2145418680,
            "generatedMachineIdentifier": 1948707,
            "machineIdentifier": 1948707,
            "generatedProcessIdentifier": 21418,
            "time": 1470425023000,
            "processIdentifier": 19905,
            "counter": 4559679,
            "timestamp": 1470425023,
            "timeSecond": 1470425023
        },
        "url": "htt://172.16.1.51/testmenot",
        "tags": [
            "testtag3",
            "testtag4"
        ],
        "status": "enabled"
    },
    {
        "port": "9100",
        "logPath": "/disk2/test.log",
        "IP": "172.16.1.50",
        "_id": {
            "date": "Sat Aug 06 00:54:13 IST 2016",
            "currentCounter": -2145418680,
            "generatedMachineIdentifier": 1948707,
            "machineIdentifier": 1948707,
            "generatedProcessIdentifier": 21418,
            "time": 1470425053000,
            "processIdentifier": 21418,
            "counter": 2064967,
            "timestamp": 1470425053,
            "timeSecond": 1470425053
        },
        "url": "htt://172.16.1.51/testmenot",
        "tags": [
            "testtag3",
            "testtag4"
        ],
        "status": "enabled"
    }
]
```


    
    
    