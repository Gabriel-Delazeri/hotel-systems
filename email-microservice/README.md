
# Email Microservice
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Gabriel-Delazeri/Email-Microservice/blob/master/LICENSE.md) 


Email microservice developed using Java Spring.

That service have the responsability of send and emails and save in database the information about this.




## Installation

Clone the file env.properties.example to an file named env.properties in the same repository, so put your enverioment variables in that file.

Now, the application is listenen to your message broker (per default, is RabbitMQ) and are ready to start.
    
## API Documentation

If you want to use the api, the complete guide next.

## Send Email

### Request

`POST /sending-email/`

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `ownerRef`      | `string` | **Required**. Email owner reference |
| `emailFrom`      | `string` | **Required, Email**. Email sender |
| `emailTo`      | `string` | **Required, Email**. Email receiver |
| `subject`      | `string` | **Required**. Email subject |
| `text`      | `string` | **Required**. Email body |

### Response (201)
```javascript
{
    "emailId": 999,
    "ownerRef": "email-microservice",
    "emailFrom": "email@micro.com",
    "emailTo": "email@micro.com",
    "subject": "Email Microservice",
    "text": "That's a explanation of how email microservice works",
    "sendDateEmail": "2023-03-06T14:30:42.235969476",
    "statusEmail": "SENT"
}
```

* The statusEmail could be SENT or ERROR.

