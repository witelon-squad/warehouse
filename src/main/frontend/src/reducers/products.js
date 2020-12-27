import { GET_PRODUCTS } from "../actions/types";

const initialState = {
    products: [],
    allProducts: []
}

export default function(state = initialState, action) {
    switch (action.type) {
        case GET_PRODUCTS:
            return {
                ...state,
                products: action.payload,
                allProducts: action.payloadAll
            };
        default:
            return state;
    }

}