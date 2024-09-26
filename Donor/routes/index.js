import { Router } from "express";
import { getUserData, getDonatables } from './db_connect.js'
import auth from './auth.js';

const router = Router();

router.use(auth);

router.get('/', async (req, res) => {
    const donor_id = req.token.donor_id;
    const donatables = await getDonatables(donor_id);
    res.render('donatables.ejs', { donatables });
});

router.get('/profile', async (req, res) => {
    const donor_id = req.token.donor_id;
    const userData = await getUserData(donor_id);
    res.render('profile.ejs', { userData });
});

export default router;
