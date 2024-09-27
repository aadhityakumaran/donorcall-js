import express from 'express';
import env from 'dotenv';
import routes from './routes/index.js';
import cookieParser from 'cookie-parser';

env.config();

const app = express();
const port = process.env.PORT || 3000;

app.use(express.urlencoded({ extended: true }));
app.use(express.json());
app.use(cookieParser());

app.use(routes);

app.use((req, res) => {
    res.status(404).json({ message: "Page not found" });
});

app.use((err, req, res, next) => {
    console.error(err.stack);
    res.status(500).json({ message: "Something Broke!" });
});

app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});
