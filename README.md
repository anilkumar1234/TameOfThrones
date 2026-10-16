# TameOfThrones

This project is a solution to famous problem from GeekTrust.

# Prerequisites
1) Java8
2) Maven

# How to test ?

1) Change your working directory to this directory ( cd <PATH>/TameOfThrones )
  
2) Execute <b>mvn clean test</b>
  
# How to execute ?

<b>mvn clean test && mvn exec:java -Dexec.mainClass="com.everest.TOTController"</b>

# Sample Input & Output

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election<br/>
<b>Input:</b> 1<br/>
<b>Output:</b> None

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election<br/>
<b>Input:</b> 2<br/>
<b>Output:</b> None

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election<br/>
<b>Input:</b> 3<br/>
Air lOsadoowerph<br/>
lAnD adaklpdn<br/>
ICE daqwmeaopuieemxamvcofethMM<br/>


Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election<br/>
<b>Input:</b> 1<br/>
<b>Output:</b> space<br/>

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election<br/>
<b>Input:</b> 2<br/>
<b>Output:</b> [air, land, ice]<br/>

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election<br/>
<b>Input:</b> 4<br/>
land<br/>
space<br/>
air<br/>

<b>Output:</b> <br/>
Results after round #1 ballot count<br/>
Allies for land : 1<br/>
Allies for air : 1<br/>
Allies for space : 0<br/>

Results after round #2 ballot count<br/>
Allies for land : 1<br/>
Allies for air : 0<br/>

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election<br/>
<b>Input:</b> 1<br/>
<b>Output:</b> land<br/>

Select any option:
1) Who is the ruler of Southeros?
2) Allies of ruler?
3) Input messages to kingdoms from King Shan
4) Select ruler by election<br/>
<b>Input:</b> 2<br/>
<b>Output:</b> [fire]<br/>

# API Token

Set the `API_TOKEN` environment variable with your token before running the application:

```
export API_TOKEN="<your-token>"
```

## Purpose

`API_TOKEN` authenticates this application when it calls the external GeekTrust-style
APIs used by the project. Without a valid token, authenticated API requests are
rejected, and the application cannot retrieve or submit data on your behalf.

## How to obtain a token

1. Sign up / log in to the API provider's developer console.
2. Create a new application or credential entry.
3. Generate an API token for that application.
4. Copy the token immediately — most providers display it only once.

Never share the token generation step with untrusted parties, and never use a
token issued to someone else.

## Permissions / scope

The token grants the permissions (scope) assigned to your account or application,
which may include reading and writing data through the project's API endpoints.
Check the provider's console to see the exact scopes, and request only the
minimum scope the application needs.

## Sensitivity

Treat `API_TOKEN` like a password. Anyone who obtains it can act as you against
the API until the token is revoked. Do not paste it into issue trackers, chat
rooms, screenshots, logs, or public repositories.

## Secure storage

- Keep the token in an environment variable (as shown above) or a secret
  management tool (e.g., a vault service, CI/CD secret store).
- Do not hardcode the token in source files, config files checked into version
  control, or container images.
- Restrict file system permissions on any file that must contain the token.
- Add `.env` and similar secret files to `.gitignore`.

## Rotation and lifecycle

- Rotate the token periodically and immediately if you suspect exposure.
- Revoke old tokens as soon as a replacement is issued.
- Use separate tokens per environment (development, staging, production) so one
  can be revoked without disrupting the others.

## Impact of compromise

If the token is exposed, an attacker can access or modify data permitted by its
scope, consume quota, and potentially perform irreversible operations as your
account. If you believe a token has leaked, revoke/rotate it immediately via the
provider's console and review audit logs for unauthorized activity.
