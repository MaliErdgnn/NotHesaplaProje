
import {createStore} from 'vuex';



// Define the initial state for the user object
const initialState = {
    user: {
        email: '',
        ad: '',
        sifre: '',
        soyad: '',
        token: '',
    },
};

// Create the Vuex store
const store =  createStore({
    state: initialState,
    mutations: {
        LOGIN(state, payload) {
            state.user = {
                ...state.user,
                email: payload.email,
                ad: payload.ad,
                sifre: payload.sifre,
                soyad: payload.soyad,
                token: payload.token,
            };
            console.log(state.user);
        },
        LOGOUT(state) {
            state.user = {
                ...state.user,
                email: '',
                ad: '',
                sifre: '',
                soyad: '',
                token: '',
            };
        },
    },
});

export default store;
