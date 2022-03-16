# OPSWAT-FILE-SCANNER

This is a project for scanning a file against metadefender.opswat.com API.

Running the project
```
mvn install
mvn exec:java -Dexec.args="upload_file $FILENAME$"
```


Sample output
```
[ Upload file for scan... ]
[ dataId: bzIyMDMxNlJpcU1kV2hna0h4d0hZRlhBMXRa ]
filename: /Users/adam/Documents/OADir/OPSWAT-FILE-SCANNER/src/main/java/FileRenderer.java
overall status: No Threat Detected
engine: AegisLab
threat_found: Clean
def_time: 2022-03-16T07:36:19.000Z
scan_result: 0
engine: CrowdStrike Falcon ML
threat_found: Clean
def_time: 2022-03-16T00:00:00.000Z
scan_result: 23
engine: Trend Micro HouseCall
threat_found: Clean
def_time: 2022-03-15T20:38:22.000Z
scan_result: 0
engine: Scrutiny
threat_found: Clean
def_time: 2022-03-16T00:00:00.000Z
scan_result: 23
engine: Vir.IT eXplorer
threat_found: Clean
def_time: 2022-03-16T12:30:00.000Z
scan_result: 0
engine: K7
threat_found: Clean
def_time: 2022-03-16T15:18:00.000Z
scan_result: 0
engine: Vir.IT ML
threat_found: Clean
def_time: 2022-03-16T12:30:00.000Z
scan_result: 0
engine: Kaspersky
threat_found: Clean
def_time: 2022-03-16T15:04:00.000Z
scan_result: 0
engine: AhnLab
threat_found: Clean
def_time: 2022-03-17T00:00:00.000Z
scan_result: 0
engine: SUPERAntiSpyware
threat_found: Clean
def_time: 2022-03-12T18:53:26.046Z
scan_result: 0
engine: Quick Heal
threat_found: Clean
def_time: 2022-03-15T22:23:00.000Z
scan_result: 0
engine: RocketCyber
threat_found: Clean
def_time: 2022-03-16T00:00:00.000Z
scan_result: 23
engine: Comodo
threat_found: Clean
def_time: 2022-03-16T12:59:16.000Z
scan_result: 0
engine: ClamAV
threat_found: Clean
def_time: 2022-03-16T08:27:50.000Z
scan_result: 0
engine: Jiangmin
threat_found: Clean
def_time: 2022-03-16T05:49:24.000Z
scan_result: 0
engine: IKARUS
threat_found: Clean
def_time: 2022-03-16T13:19:23.000Z
scan_result: 0
engine: Huorong
threat_found: Clean
def_time: 2022-03-16T08:37:25.000Z
scan_result: 0
engine: Bitdefender
threat_found: Clean
def_time: 2022-03-16T16:40:00.000Z
scan_result: 0
engine: HAURI
threat_found: Clean
def_time: 2022-03-16T00:00:00.000Z
scan_result: 0
engine: Avira
threat_found: Clean
def_time: 2022-03-16T17:57:00.000Z
scan_result: 0
engine: Filseclab
threat_found: Clean
def_time: 2022-03-15T23:35:40.000Z
scan_result: 0
engine: Zillya!
threat_found: Clean
def_time: 2022-03-16T11:43:00.000Z
scan_result: 0
engine: Sophos
threat_found: Clean
def_time: 2022-03-16T06:27:29.000Z
scan_result: 0
engine: VirusBlokAda
threat_found: Clean
def_time: 2022-03-16T17:56:23.000Z
scan_result: 0
engine: McAfee
threat_found: Clean
def_time: 2022-03-16T00:00:00.000Z
scan_result: 0
engine: Cyren
threat_found: Clean
def_time: 2022-03-16T17:55:00.000Z
scan_result: 0
engine: TACHYON
threat_found: Clean
def_time: 2022-03-16T00:00:00.000Z
scan_result: 0
engine: Antiy
threat_found: Clean
def_time: 2022-03-16T13:22:00.000Z
scan_result: 0
engine: Xvirus Anti-Malware
threat_found: Clean
def_time: 2022-03-16T00:28:12.000Z
scan_result: 0
engine: Microsoft Defender
threat_found: Clean
def_time: 2022-03-16T12:40:33.000Z
scan_result: 0
engine: Trend Micro
threat_found: Clean
def_time: 2022-03-15T20:22:46.000Z
scan_result: 0
engine: Webroot SMD
threat_found: Clean
def_time: 2022-03-15T21:00:10.000Z
scan_result: 23
engine: Emsisoft
threat_found: Clean
def_time: 2022-03-16T17:09:00.000Z
scan_result: 0
engine: NANOAV
threat_found: Clean
def_time: 2022-03-16T17:06:00.000Z
scan_result: 0
engine: ESET
threat_found: Clean
def_time: 2022-03-16T15:18:04.000Z
scan_result: 0

```