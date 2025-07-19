# Uber-like Ride Booking Application (Kafka + Oracle DB)

This project is a simplified version of an Uber-like ride booking system, built using **Spring Boot**, **Apache Kafka**, and **Oracle Database**.

The system enables a user to request a ride, processes the ride request using Kafka, stores the request in the Oracle database, and allows drivers to view and accept available rides. Once a ride is accepted by a driver, it is hidden from all other drivers and assigned to the requesting user.

---

## 🧠 Core Features

- **Ride Request Handling**: When a user requests a ride, the request data is sent to Kafka and then consumed and stored in the Oracle database.
  
- **Driver Ride Access**: Drivers can view all **available rides** that are not yet accepted (i.e., rides with status `PENDING`).

- **Ride Acceptance Logic**:
  - When a driver accepts a ride:
    - The ride status is updated to `ACCEPTED`.
    - Other drivers will no longer see this ride.
    - The driver's details are shared with the user who requested the ride.

---

## 🛠️ Tech Stack

- **Spring Boot** – Backend framework
- **Apache Kafka** – Message queue for asynchronous processing
- **Oracle Database** – Persistent storage for ride data
- **Kafka Producer & Consumer** – For sending and receiving messages

---

## ⚙️ Kafka Integration

- The application uses Kafka **Producer** to send ride request data to a Kafka **Topic**.
- A Kafka **Consumer** listens to the topic and stores the ride data into Oracle DB.
- Kafka decouples the ride request flow from the database logic, enabling scalable and reliable event-driven architecture.

---

## 🗄️ Database Tables (Oracle)

### `RIDES` Table

| Column Name     | Data Type | Description                        |
|------------------|-----------|------------------------------------|
| RIDE_ID          | NUMBER    | Primary key                        |
| USER_ID          | NUMBER    | ID of the user who requested ride |
| PICKUP_LOCATION  | VARCHAR2  | Start location                     |
| DROP_LOCATION    | VARCHAR2  | Destination location               |
| STATUS           | VARCHAR2  | PENDING / ACCEPTED                 |
| DRIVER_ID        | NUMBER    | ID of the driver who accepted ride|
| DRIVER_NAME      | VARCHAR2  | Name of the driver                 |

> Note: Only rides with `STATUS = 'PENDING'` are visible to all drivers. Once a ride is accepted, it changes to `ACCEPTED`.

---

## 🔄 Flow of Data
User Request Ride
↓
Kafka Producer (sends message)
↓
Kafka Topic ("ride-requests")
↓
Kafka Consumer (reads message)
↓
Oracle DB (stores ride data)
↓
Drivers View Available Rides
↓
Driver Accepts Ride
↓
Ride marked as ACCEPTED and user notified with driver details

---

## 🧪 Testing

You can use **Postman** or any API testing tool to simulate:

- User sending ride request
- Drivers fetching available rides
- A driver accepting a ride

All data will be stored and updated in Oracle DB through Kafka processing.

---

## 📦 Future Scope

- Authentication (JWT) for drivers and users
- Real-time notifications via WebSocket
- Kafka Streams or Kafka Connect for analytics and integration
- Frontend in React or Angular

---

## 👨‍💻 Developer

**Your Name**  
Uber-like Ride Booking System — Kafka + Oracle

---



