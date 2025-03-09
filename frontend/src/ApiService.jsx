import axios from "axios";

export default class Authentication{

    static BASE_URL="http://localhost:8080";
    static getHeader(){
        const token=localStorage.getItem("token");
        return {
            "Authorization":`Bearer ${token}`,
            "Content-Type":"application/json"
        };
    }

    static async register(registerDetails){
        const response=await axios.post(`${this.BASE_URL}/register`,
            registerDetails
        );
        return response.data;

    }
    static async login(loginDetails){
        const response=await axios.post(`${this.BASE_URL}/login`,
            loginDetails
        );
        return response.data;
    }

    static async admin(){
        const token=localStorage.getItem('token');
        console.log(token);
        const response=await axios.get(`${this.BASE_URL}/admin_only`,
            {headers: this.getHeader()}
        );
        return response.data;
    }

}