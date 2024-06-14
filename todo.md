# Social Media Platform

## Features and Endpoints

> [!NOTE]
> Be aware that not all features listed here may be implemented in current version

### User Profiles
- **Features:**
    - User Registration
    - User Login/Logout
    - Profile Management (Update profile, profile picture)
    - View other user profiles

- **Endpoints:**
    - `POST /auth/register` - Register a new user
    - `POST /auth/login` - User login
    - `POST /auth/logout` - User logout
    - `GET /users` - Get all users
    - `GET /users/{id}` - Get user by ID
    - `PUT /users/{id}` - Update user profile
    - `DELETE /users/{id}` - Delete user profiler

### Posts and Comments
- **Features:**
    - Create, read, update, delete (CRUD) posts
    - Create, read, update, delete (CRUD) comments on posts

- **Endpoints:**
    - `GET /posts` - Get all posts
    - `GET /posts/{id}` - Get post by ID
    - `POST /posts` - Create a new post
    - `PUT /posts/{id}` - Update a post
    - `DELETE /posts/{id}` - Delete a post
    - `GET /posts/{id}/comments` - Get comments for a post
    - `POST /posts/{id}/comments` - Add a comment to a post
    - `PUT /posts/{id}/comments/{commentId}` - Update a comment
    - `DELETE /posts/{id}/comments/{commentId}` - Delete a comment

### Likes and Reactions
- **Features:**
    - Like/unlike posts
    - Like/unlike comments

- **Endpoints:**
    - `POST /posts/{id}/like` - Like a post
    - `DELETE /posts/{id}/like` - Unlike a post
    - `POST /posts/{id}/comments/{commentId}/like` - Like a comment
    - `DELETE /posts/{id}/comments/{commentId}/like` - Unlike a comment

### Friends/Followers Management
- **Features:**
    - Send and accept friend requests
    - Follow/unfollow users
    - View friends/followers list

- **Endpoints:**
    - `POST /users/{id}/friend-request` - Send a friend request
    - `POST /users/{id}/accept-friend-request` - Accept a friend request
    - `DELETE /users/{id}/remove-friend` - Remove a friend
    - `POST /users/{id}/follow` - Follow a user
    - `DELETE /users/{id}/unfollow` - Unfollow a user
    - `GET /users/{id}/friends` - Get friends list
    - `GET /users/{id}/followers` - Get followers list
    - `GET /users/{id}/following` - Get following list

### Private Messaging
- **Features:**
    - Send/receive messages
    - Read/unread status
    - Delete messages

- **Endpoints:**
    - `GET /messages` - Get all messages
    - `GET /messages/{id}` - Get message by ID
    - `POST /messages` - Send a new message
    - `DELETE /messages/{id}` - Delete a message

### Notifications
- **Features:**
    - Real-time notifications for likes, comments, friend requests, messages
    - Mark notifications as read/unread

- **Endpoints:**
    - `GET /notifications` - Get all notifications
    - `POST /notifications/mark-read` - Mark notifications as read

### Media Upload and Management
- **Features:**
    - Upload profile pictures, post images, videos
    - View/delete uploaded media

- **Endpoints:**
    - `POST /media/upload` - Upload media
    - `GET /media/{id}` - Get media by ID
    - `DELETE /media/{id}` - Delete media

## Additional Features

### Search
- **Features:**
    - Search users, posts, and comments

- **Endpoints:**
    - `GET /search/users?q={query}` - Search users
    - `GET /search/posts?q={query}` - Search posts
    - `GET /search/comments?q={query}` - Search comments

### Admin Panel
- **Features:**
    - User management (block/unblock users)
    - Content moderation (remove inappropriate posts/comments)

- **Endpoints:**
    - `POST /admin/users/{id}/block` - Block a user
    - `POST /admin/users/{id}/unblock` - Unblock a user
    - `DELETE /admin/posts/{id}` - Delete a post
    - `DELETE /admin/comments/{id}` - Delete a comment