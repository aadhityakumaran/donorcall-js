import express from 'express';
import env from 'dotenv';
import webPageRoutes from './routes/index.js';
import apiRoutes from './routes/api/v1/index.js';
import cookieParser from 'cookie-parser';

env.config();

const app = express();
const port = process.env.PORT || 3000;

app.use(express.urlencoded({ extended: true }));
app.use(express.json());
app.use(cookieParser());

app.use(express.static('public'));
app.set('view engine', 'ejs');

app.use('/api/v1', apiRoutes);
app.use(webPageRoutes);

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
