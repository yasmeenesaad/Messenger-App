# Simple Messenger App

## Overview

The Simple Messenger App is a lightweight application designed to facilitate communication between users. It supports messaging, user profiles, and comments, providing a seamless user experience. The app is built using modern web technologies and follows best practices in software development.

## Features

- **Messages**: Users can send and receive messages in real-time.
- **Profiles**: Each user has a profile that displays their information and activity.
- **Comments**: Users can comment on messages and engage in discussions.

## Architecture

The application is designed using a RESTful architecture, ensuring that all interactions with the server are stateless and follow standard HTTP methods. Key features include:

- **RESTful APIs**: The app provides a set of RESTful endpoints for managing messages, user profiles, and comments.
- **Exception Handling**: Comprehensive error handling is implemented to manage and respond to various exceptions, ensuring a robust user experience.
- **HATEOAS**: The app follows the HATEOAS (Hypermedia as the Engine of Application State) principle, allowing clients to navigate the API dynamically through hyperlinks provided in the responses.

## Getting Started

To run the Simple Messenger App locally, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/yasmeenesaad/Messenger-App.git

## API Endpoints

### Messages
- **`GET /api/messages`**: Retrieve all messages.
- **`POST /api/messages`**: Send a new message.

### Profiles
- **`GET /api/profiles`**: Retrieve all user profiles.
- **`GET /api/profiles/{id}`**: Retrieve a specific user profile.

### Comments
- **`GET /api/comments`**: Retrieve all comments.
- **`POST /api/comments`**: Add a new comment.
