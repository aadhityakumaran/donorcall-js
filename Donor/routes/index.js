import { Router } from "express";
import { isValidLogin, registerUser, getUserData, getDonatables } from './db_connect.js'

const router = Router();

router.get('/', async (req, res) => {
    const donor_id = req.query.donor_id;
    const donatables = await getDonatables(donor_id);
    res.render('donatables.ejs', { donatables });
});

router.get('/login', async (req, res) => {
    res.render('login.ejs');
});

router.post('/login', async (req, res) => {
    const { donor_id, password } = req.body;
    const isValid = await isValidLogin(donor_id, password);
    if (isValid) {
        res.redirect('/');
    } else {
        res.json({ message: "Invalid credentials" });
    }
    res.json({ message: "This is the login route" });
});

router.get('/signup', (req, res) => {
    res.render('signup.ejs');
});

router.post('/signup', async (req, res) => {
    const { password, name, phone, blood_group } = req.body;
    await registerUser(password, name, phone, blood_group);
    res.redirect('/');
});

router.get('/profile', async (req, res) => {
    const donor_id = req.query.donor_id;
    const userData = await getUserData(donor_id);
    res.render('profile.ejs', { userData });
});

router.get('/logout', (req, res) => {
    res.json({ message: "This is the logout route" });
});

export default router;
