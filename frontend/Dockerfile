FROM node:12.18.1-alpine AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
# Copy node modules
COPY . . 
RUN npm run build

EXPOSE 8081
CMD ["npm", "run", "serve"]


