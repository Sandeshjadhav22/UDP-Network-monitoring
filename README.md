# UDP Network Monitoring Tool

## 📌 Project Overview
This is a **UDP Network Monitoring Tool** built in Java that captures and logs UDP packets sent and received on a system. It helps detect high-traffic sources, packet loss, and network issues.

## 🚀 Features
- Captures **incoming UDP packets** on a specified port.
- Logs **source IP, port, packet size, and timestamp**.
- Saves packet logs to a `udp_log.txt` file.
- Allows testing via a UDP client or `netcat`.

## 🛠️ Setup and Installation
### **1️⃣ Clone the Repository**
```sh
git clone https://github.com/your-username/udp-network-monitor.git
cd udp-network-monitor
```

### **2️⃣ Compile the Java Files**
```sh
javac UDPPacketSniffer.java UDPClient.java
```

## 📡 Running the UDP Packet Sniffer
Start the sniffer to listen on port **9999**:
```sh
java UDPPacketSniffer
```
You should see:
```sh
UDP Packet Sniffer started on port 9999
```

## 📤 Sending Test Packets
### **Option 1: Using Netcat (Linux/macOS/WSL)**
Send a UDP message:
```sh
echo "Hello, UDP!" | nc -u 127.0.0.1 9999
```

### **Option 2: Using Java UDP Client**
Run the UDP client to send a test message:
```sh
java UDPClient
```

## 📑 Log File
All captured packets are logged in **udp_log.txt** with details like:
```
[2025-03-28 12:34:56] Received UDP packet from /127.0.0.1:54321 | Size: 12 bytes | Data: Hello, UDP!
```

## 🏗️ Future Enhancements
- 📊 Real-time traffic monitoring (packet count, data rate).
- 🚨 Alerts for high traffic or suspicious activity.
- 🌍 Web-based dashboard for better visualization.

## 🤝 Contributing
Feel free to fork this repo and submit a pull request with improvements!

---
✅ **Developed by Sandesh**

