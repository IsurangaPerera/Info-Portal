FROM java:8-jre

WORKDIR /opt

# --------------------------------
# Copy scripts, packages & plugins
# --------------------------------
COPY packages/petstore-pet.jar /opt/

#----------------------
# Expose container ports
# ----------------------
EXPOSE 8080

ENTRYPOINT java -jar /opt/info-model.jar