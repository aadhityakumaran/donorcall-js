import mysql from 'mysql2';
import crypto from 'crypto';
import env from 'dotenv';

env.config();

const config = {
    host: process.env.DB_HOST || "localhost",
    user: process.env.DB_USER || "root",
    password: process.env.DB_PASSWORD || "4971",
    database: process.env.DB_DATABASE || "blood",
}

const connection = mysql.createConnection(config);
connect();

function connect() {
    connection.connect((err) => {
        if (err) {
            console.error('Error connecting to database: ', err);
            throw err;
        }
        console.log('Connected to database');
    });
}

async function isValidLogin(donor_id, password) {
    const query = `SELECT * FROM users WHERE donor_id = ? AND pwd = ?`;
    const [rows, fields] = await connection.promise().query(query, [donor_id, hashPassword(password)]);
    return rows.length > 0;
}

async function registerUser(password, name, phone, blood_group) {
    const donorId = Math.floor(Math.random() * 9000) + 1000;
    const query = `INSERT INTO users (donor_id, pwd, phone, name, blood) VALUES (?, ?, ?, ?, ?)`;
    await connection.promise().query(query, [donorId, hashPassword(password), phone, name, blood_group.substring(0, 2)]);
    return donorId;
}

async function getUserData(donor_id) {
    const query = `SELECT name, phone, blood, last_don FROM users WHERE donor_id = ?`;
    const [rows, fields] = await connection.promise().query(query, [donor_id]);
    return rows[0];
}

async function getBloodGroup(donor_id) {
    const query = `SELECT blood FROM users WHERE donor_id = ?`;
    const [rows, fields] = await connection.promise().query(query, [donor_id]);
    return rows[0].blood;
}

async function getDonatables(donor_id) {
    const blood_group = await getBloodGroup(donor_id);
    const query = `SELECT patient_id, name, age, blood, phone, info FROM hospital WHERE blood = ?`;
    const [rows, fields] = await connection.promise().query(query, [blood_group]);
    return rows;
}

function hashPassword(password) {
    const hash = crypto.createHash('sha256');
    hash.update(password, 'utf-8');
    return hash.digest();
}

export {
    isValidLogin,
    registerUser,
    getUserData,
    getDonatables
};