# social-insurance-verification-service
Social Insurance Verification Service

docker network create -d bridge social-insurance  
docker network ls  

docker build -t onlineinteract/social-insurance-verification-service .  
docker run -it -d -p 9085:9085 --network="social-insurance" --name social-insurance-verification-service onlineinteract/social-insurance-verification-service  

All optional:

docker create -it onlineinteract/social-insurance-verification-service bash  
docker ps -a  
docker start ####  
docker ps  
docker attach ####  
docker remove ####  
docker image rm onlineinteract/social-insurance-verification-service  
docker exec -it social-insurance-verification-service sh  