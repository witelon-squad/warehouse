import { GET_ERROR } from './types';

export const returnError = (msg, status) => {
    return {
        type: GET_ERROR,
        payload: { msg, status }
    };
};

