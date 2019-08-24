#!/bin/bash
bottoken=$1
channelid=$2
message=${@:3}
/usr/bin/curl --silent \
-H "Authorization: Bot ${bottoken}" \
-H "User-Agent: Solinia.Server" \
-H "Content-Type: application/json" \
-X POST \
-d "{\"content\":\"$message\"}" \
https://discordapp.com/api/channels/$channelid/messages
