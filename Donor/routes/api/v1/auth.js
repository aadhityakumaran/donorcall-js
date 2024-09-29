import jwt from 'jsonwebtoken';
import e, { Router } from 'express';
import { isValidLogin, registerUser } from './../../../db_connect.js';

const router = Router();

router.post('/login', async (req, res) => {
    const { donor_id, password } = req.body;
    const isValid = await isValidLogin(donor_id, password);

    if (isValid) {
        const token = jwt.sign({ donor_id }, process.env.SECRET_KEY, { expiresIn: "1h" });
        return res.json({ token });
    }
    
    res.status(401).json({ message: "Invalid credentials" });
});

router.post('/signup', async (req, res) => {
    const { password, name, phone, blood_group } = req.body;
    const donor_id = await registerUser(password, name, phone, blood_group);
    const token = jwt.sign({ donor_id }, process.env.SECRET_KEY);
    res.json({ token });
});

router.use((req, res, next) => {
    const authHeader = req.headers.authorization;
    const token = authHeader && authHeader.split(' ')[1];

    if (!token) {
        return res.sendStatus(401);
    }

    try {
        const decoded = jwt.verify(token, process.env.SECRET_KEY);
        req.token = decoded;
    } catch (err) {
        return res.sendStatus(403);
    }
    next();
});

export default router;