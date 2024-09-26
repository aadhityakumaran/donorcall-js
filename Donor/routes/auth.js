import { Router } from "express";

const router = Router();

router.use((req, res, next) => {
    const token = req.cookies.token;
    if (token) {
        try {
            const decoded = jwt.verify(token, process.env.SECRET_KEY);
            req.token = decoded;
        } catch (err) {
            console.error(err);
        }
    }
    next()
});

router.get('/login', async (req, res) => {
    res.render('login.ejs');
});

router.post('/login', async (req, res) => {
    const { donor_id, password } = req.body;
    const isValid = await isValidLogin(donor_id, password);
    if (isValid) {
        const token = jwt.sign({ donor_id }, process.env.SECRET_KEY);
        res.cookie("token", token, { httpOnly: true });
        const redirectTo = req.cookies.redirectTo || "/";
        res.clearCookie("redirectTo");
        res.redirect(redirectTo);
    } else {
        res.json({ message: "Invalid credentials" });
    }
});

router.get('/signup', (req, res) => {
    res.clearCookie("token");
    res.render('signup.ejs');
});

router.post('/signup', async (req, res) => {
    const { password, name, phone, blood_group } = req.body;
    await registerUser(password, name, phone, blood_group);
    res.redirect('/');
});


router.get('/logout', (req, res) => {
    res.clearCookie("token");
    res.redirect('/');
});

router.use((req, res, next) => {
    const token = req.token;
    if (!token) {
        res.clearCookie("token");
        res.cookie("redirectTo", req.originalUrl, { httpOnly: true });
        return res.redirect("/login");
    }
    next();
});

export default router;