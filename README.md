# ChatSocket

## _A Decentralised Chat App Made Possible with Sockets Written in JAVA_

A network socket is a software structure within a network node of a computer network that serves as an endpoint for sending and receiving data across the network. In other words, it's like a magical portal for your data to travel through the internet! ✨

## Screenshots

<img align="center" alt="GIF" src="README_ASSETS/1.PNG" width="100%" />

## How it works?

- ✨ Magic ✨ (and a lot of Java)

## Features

- **Decentralised:** No central server, just pure peer-to-peer goodness!
- **Peer to Peer:** Talk directly to your friends without any middleman.
- **Secure as Heck:** Because who doesn't love a bit of security?
- **Lightweight:** So light, it might float away!
- **Better texting than Whatsapp probably:** At least that's what we like to think!

## What I Used

- **sOcKeTs:** The backbone of our chat app.
- **Threading:** Because multitasking is cool.
- **Streams:** For smooth data flow.
- **Exception Handling:** Because errors happen, and we're ready for them!
- **Google to Find Public IP:** Because sometimes you need a little help.
- **My two braincells left:** The real heroes behind this project.

## Installation

Requires JDK to run. (Obviously, duh!)

### For Client

```sh
javac Client.java
java Client
```

### For Server

```sh
javac Server.java
java Server
```

## IMPORTANT

Everything is in the `code` folder.

Keep Client and Server files away from each other if you're trying this out on localhost. The class names are the same, so while compiling, the class files will be replaced by Client or Server depending on which you compile after which. Keeping both files in separate folders (like they are now) eliminates this issue.

> But Brij, you should have renamed the classes to avoid these conflicts, and why are there two files even? You could have surely filtered it into a singular file for Server and Client both.

Well...

> My answer: It is what it is. I made this in a hurry, and I don't feel like doing it now, but hey, you can always do it yourself. Don't forget to make a pull request. (LOL)

## I Still Don't Understand How to Make This Work

Basically, one PC will run the Client file, and another will run the Server file. (Or not, you can run both on the same PC in different terminals to have fun!)

You'll need the Public IPv6 of the PC running the Server. It's needed to establish a Socket connection. Remember, P U B L I C - I P v 6! It'll ask you for it when you run the Client program. It should also have worked for IPv4, but for some reason, it doesn't. Meh.

If you're running this on the same PC, just give `localhost` as the IP.

<br><br>
Made with Shear Agony and Distaste for the World ❤ by Brijrajsinh Parmar
