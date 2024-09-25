import { Router } from "express";

const router = Router();

router.get('/', (req, res) => {
    res.json({ message: "This is the home route" });
});

router.get('/login', (req, res) => {
    res.json({ message: "This is the login route" });
});

router.get('/signup', (req, res) => {
    res.json({ message: "This is the signup route" });
});

router.get('/profile', (req, res) => {
    res.json({ message: "This is the profile route" });
});

router.get('/logout', (req, res) => {
    res.json({ message: "This is the logout route" });
});

export default router;
