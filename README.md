# Build-Time Auto-Instrumentation for Android

This repo contains a demo that supports supports the 
"Built-Time Auto-Instrumentation for Android" talk
at Kubecon NA, Salt Lake City, UT, 2024.

Google slides deck is 
[here](https://docs.google.com/presentation/d/1gHyeWBtTRG-ZxJpu0QIefLr4wi15B91C/edit?usp=sharing&ouid=113208723375802417212&rtpof=true&sd=true).

# Running

Fire up jaeger:
```bash
./jaeger.sh
```

Run the backend server:
```bash
cd server
$ node server.js 2>/dev/null
```

Run the demo app in Intellij and 

To view telemetry in Jaeger:
http://localhost:16686