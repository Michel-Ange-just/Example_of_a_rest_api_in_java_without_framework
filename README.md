
# Java Low‑Level HTTP Server

This project implements a **minimalist low‑level HTTP server** in Java using:

- **ServerSocket** to accept client connections  
- **BufferedReader** to read HTTP requests  
- **BufferedWriter** to send HTTP responses  
- A simple internal protocol for handling GET/POST requests  

The goal is to provide a clear, educational example of how an HTTP server works **without any frameworks**.


## Features

- **TCP connection handling** using `ServerSocket`
- **HTTP request parsing** (method, headers, body)
- Support for **GET** and **POST**
- Header extraction (e.g., `Content-Length`)
- Properly formatted HTTP responses
- Persistent connection until the client closes it
- Clean and readable code suitable for learning


##  Build & Run

### 1. Compile the project

```bash
javac src/*.java
```

### 2. Start the server

```bash
java Main
```

The server listens on **port 8080** by default.



## Example HTTP Requests

### GET request

```
GET / HTTP/1.1
Host: localhost
```

### POST request

```
POST /data HTTP/1.1
Host: localhost
Content-Length: 11

Hello World
```



## Example HTTP Response

```http
HTTP/1.1 200 OK
Content-Type: text/plain
Content-Length: 13

Hello, world!
```



##  Internal Logic

###  Reading the request

```java
while ((line = in.readLine()) != null) {
    if (line.startsWith("Content-Length:")) {
        contentLength = Integer.parseInt(line.split(":")[1].trim());
    }
}
```

- `readLine()` reads one HTTP header line  
- `split(":")[1]` extracts the header value  
- `trim()` removes extra spaces  

### Sending the response

```java
out.write("HTTP/1.1 200 OK\r\n");
out.write("Content-Type: text/plain\r\n");
out.write("Content-Length: 13\r\n");
out.write("\r\n");
out.write("Hello, world!");
out.flush();
```


## Educational Purpose

This project helps you understand:

- How **low‑level sockets** work  
- How to parse an HTTP request manually  
- How to build a valid HTTP response  
- How to manage client connections and streams  

