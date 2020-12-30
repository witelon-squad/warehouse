import { GET_PRODUCTS, ADD_NEW_PRODUCT } from "../actions/types";

const initialState = {
    products: [],
    listOfProducts: [],
}

export default function (state = initialState, action) {
    switch (action.type) {
        case GET_PRODUCTS:
            return {
                ...state,
                products: action.payload,
                listOfProducts: action.payloadAll
            };
        case ADD_NEW_PRODUCT:
            return {
                ...state,
                listOfProducts: [...state.listOfProducts, action.payload]
            };
        default:
            return state;
    }

}