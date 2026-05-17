FROM groovy:2.5.2-jdk8-alpine

ARG CREATED=unspecified
ARG REVISION=unspecified
ARG SOURCE=unspecified
LABEL org.opencontainers.image.created="$CREATED"
LABEL org.opencontainers.image.revision="$REVISION"
LABEL org.opencontainers.image.source="$SOURCE"

WORKDIR /sst
COPY src /sst/

ENV PROFILE_LIST 'default lmi/genworth lmi/qbe'

# This is for default fakehost port
EXPOSE 7361 
CMD groovy Server.groovy $PROFILE_LIST