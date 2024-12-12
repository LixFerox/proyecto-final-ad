import sqlite3 from 'sqlite3';
import path from 'path';

const dataBasePath = path.resolve("./database/company_database.db")
const createDataBase=new sqlite3.Database(dataBasePath);

export function getConnection(query: string) {
    return new Promise((resolve, reject) => {
        createDataBase.all(query, (err, rows) => {
            if (err) {
                reject(err);
            } else {
                resolve(rows);
            }
        })
    })
}