FROM node:16-alpine3.12 as node
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod





FROM nginx:1.20.2-alpine
COPY --from=node /app/dist/insurance/ /usr/share/nginx/html