# Install Docker on Ubuntu
1. Set up Docker's `apt` repository
```
# Add Docker's official GPG key:
sudo apt-get update
sudo apt-get install ca-certificates curl
sudo install -m 0755 -d /etc/apt/keyrings
sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
sudo chmod a+r /etc/apt/keyrings/docker.asc

# Add the repository to Apt sources:
echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] https://download.docker.com/linux/ubuntu \
  $(. /etc/os-release && echo "${UBUNTU_CODENAME:-$VERSION_CODENAME}") stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
sudo apt-get update
```
2. Install the Docker packages
```
sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```
3. Verify that the installation is successful by running the `hello-world` image:
```
sudo docker run hello-world
```
4. Upgrade Docker Engine

To upgrade Docker Engine, follow step 2 of the installation instructions, choosing the new version you want to install.

# Manage Docker as a non-root user
1. Create the docker group.

```
sudo groupadd docker
```
2. Add your user to the docker group.

```
sudo usermod -aG docker $USER
```
3. Run the following command to activate the changes to groups:
```
newgrp docker
```
4. Verify that you can run docker commands without sudo.
```
docker run hello-world
```

# Configure Docker to start on boot with systemd
1. To automatically start Docker and containerd on boot for other Linux distributions using systemd, run the following commands:
```
sudo systemctl enable docker.service
sudo systemctl enable containerd.service
```

2. To stop this behavior, use disable instead.
```
sudo systemctl disable docker.service
sudo systemctl disable containerd.service
```
# COMMANDS
## DOCKER INFO
1. To check version:
```
docker --version
```
## IMAGE
1. Pull image from docker hub
```
docker image pull [OPTIONS] NAME[:TAG|@DIGEST]
```
2. Show all images:
```
docker images
```
3. Delete an image
```
docker rmi <REPOSITORY or IMAGE ID>
```
4. Remove unused images
```
docker image prune
```
5. Build an image from a Dockerfile (version is optional)
```
docker build -t <REPOSITORY or IMAGE ID>:<VERSION> .
```
Build without cache
```
docker build -t <REPOSITORY or IMAGE ID>:<VERSION> . -no-cache
```
## CONTAINER
1. To build and run container from image:
```
docker run <REPOSITORY or IMAGE ID>
```
2. To build and run container in interactive mode from image:
```
docker run -it <REPOSITORY or IMAGE ID>
```
3. Run container in background
```
docker run -d <REPOSITORY or IMAGE ID>
```
4. Run container with custom name
```
docker run - -name <NEW NAME> <EPOSITORY or IMAGE ID>
```
5. Set environment variables in a container
```
docker run -e <VAR NAME>=<VAR VALUE> <CONTAINER ID or NAMES>
```
6. Port Binding in container
```
docker run -p<HOST PORT>:<CONTAINER PORT> <POSITORY or IMAGE ID>
```
7. To show all containers:
```
docker ps -a
```
8. To show running containers:
```
docker ps
```
9. To run an existing container:
```
docker start <CONTAINER ID or NAMES>
```
10. To stop a running container:
```
docker stop <CONTAINER ID or NAMES>
```
11. Inspect a running container
```
docker inspect <CONTAINER ID or NAMES>
```
12. Delete a container
```
docker rm <CONTAINER ID or NAMES>
```

## VOLUMES
1. List all Volumes
```
docker volume ls
```
2. Create new Named volume
```
docker volume create <VOLUME NAME>
```
3. Delete a Named volume
```
docker volume rm <VOLUME NAME>
```
4. Mount Named volume with running container
```
docker run --volume <VOLUME NAME>:<MOUNT PATH>
```
or using --mount
```
docker run --mount type=volume,src=<VOLUME NAME>,dest=<MOUNT PATH>
```
5. Mount Anonymous volume with running container
```
docker run --volume <MOUNT PATH>
```
6. To create a Bind Mount
```
docker run --volume <HOST PATH>:<CONTAINER PATH>
```
or using --mount
```
docker run --mount type=bind,src=<HOST PATH>,dest=<CONTAINER PATH>
```
7. Remove unused local anonymous volumes
```
docker volume prune
```

## NETWORK
1. List all networks
```
docker network ls
```
2. Create a network
```
docker network create <NAME>
```
3. Remove a network
```
docker network rm <NAME>
```
4. Remove all unused networks
```
docker network prune
```

## DOCKER COMPOSE
1. Run containers defined in a docker-compose.yml file
```
docker-compose up
```

2. Run containers in detached mode (background)
```
docker-compose up -d
```

3. Build or rebuild services
```
docker-compose build
```

4. Stop and remove containers, networks, images, and volumes
```
docker-compose down
```

5. Stop and remove containers and networks, but preserve volumes
```
docker-compose down --volumes
```

6. View running containers managed by docker-compose
```
docker-compose ps
```

7. View logs from containers
```
docker-compose logs
```

8. View logs from specific service
```
docker-compose logs <SERVICE_NAME>
```

9. Follow log output (like tail -f)
```
docker-compose logs -f
```

10. Execute a command in a running container
```
docker-compose exec <SERVICE_NAME> <COMMAND>
```

11. Start services
```
docker-compose start
```

12. Stop services
```
docker-compose stop
```

13. Restart services
```
docker-compose restart
```

14. Pause services
```
docker-compose pause
```

15. Unpause services
```
docker-compose unpause
```

16. List images used by created containers
```
docker-compose images
```

17. Scale a service to multiple instances
```
docker-compose up -d --scale <SERVICE_NAME>=<NUM_INSTANCES>
```

18. Validate and view the configuration
```
docker-compose config
```

19. Run a one-time command on a service without starting persistent containers
```
docker-compose run <SERVICE_NAME> <COMMAND>
```

20. Pull images for services defined in docker-compose.yml
```
docker-compose pull
```

21. Push images for services defined in docker-compose.yml
```
docker-compose push
```

## DOCKER HUB
1. Pull an image from DockerHub
```
docker pull <REPOSITORY or IMAGE ID>
```
2. Publish an image to DockerHub
```
docker push <USER NAME>/<REPOSITORY or IMAGE ID>
```
3. Login into DockerHub
```
docker login -u <USER NAME>
```
Or
```
docker login
```
4. logout from DockerHub
```
docker logout
```
5. Search for an image on DockerHub
```
docker search <REPOSITORY or IMAGE ID>
```

## DOCKER SYSTEM
1. Display Docker disk usage information
```
docker system df
```

2. Display detailed Docker disk usage information
```
docker system df -v
```

3. Remove all unused Docker objects (containers, networks, images, volumes)
```
docker system prune
```

4. Remove all unused Docker objects including volumes
```
docker system prune --volumes
```

5. Remove unused Docker images only
```
docker system prune --all
```

6. Display real-time events from the Docker server
```
docker system events
```

7. Display system-wide information about Docker
```
docker system info
```

8. Check Docker API version compatibility
```
docker system version
```

9. Monitor resource usage statistics of running containers
```
docker stats
```

10. Monitor resource usage of specific containers
```
docker stats <CONTAINER ID or NAMES>
```

## DOCKER ORPHANS
1. List orphaned containers (containers not associated with a running service)
```
docker container ls -a --filter "status=exited" --filter "label=com.docker.compose.project"
```

2. Remove orphaned containers when bringing up Docker Compose services
```
docker-compose up --remove-orphans
```

3. Remove orphaned containers when shutting down Docker Compose services
```
docker-compose down --remove-orphans
```

4. Find and remove dangling images (images not tagged or used by any container)
```
docker images -f "dangling=true" -q
docker rmi $(docker images -f "dangling=true" -q)
```

5. Find containers using a specific volume (to identify orphaned volumes)
```
docker ps -a --filter volume=VOLUME_NAME
```

6. Find containers using a specific network (to identify orphaned networks)
```
docker ps -a --filter network=NETWORK_NAME
```

## TROUBLESHOOT
1. Fetch logs of a container
```
docker logs <CONTAINER ID or NAMES>
```
2. Open shell inside running container
```
docker exec -it <CONTAINER ID or NAMES> /bin/bash
```
```
docker exec -it <CONTAINER ID or NAMES> sh
```
