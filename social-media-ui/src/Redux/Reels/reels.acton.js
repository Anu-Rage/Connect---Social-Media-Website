import { api } from "../../config/api"
import { LIKE_POST_FAILUER, LIKE_POST_REQUEST, LIKE_POST_SUCCESS, SAVE_POST_FAILUER, SAVE_POST_REQUEST, SAVE_POST_SUCCESS } from "../Post/post.actionType"
import { CREATE_REELS_FAILUER, CREATE_REELS_REQUEST, CREATE_REELS_SUCCESS, GET_ALL_REELS_FAILUER, GET_ALL_REELS_REQUEST, GET_ALL_REELS_SUCCESS, GET_USERS_REEL_FAILUER, GET_USERS_REEL_REQUEST, GET_USERS_REEL_SUCCESS, LIKE_REELS_FAILUER, LIKE_REELS_REQUEST, LIKE_REELS_SUCCESS } from "./reels.actionType"

export const createReels=(reelData)=>async (dispatch)=>{
    dispatch({type:CREATE_REELS_REQUEST})
    try {

        const {data} = await api.post("/api/reels",reelData)

        dispatch({type:CREATE_REELS_SUCCESS,payload:data})

        console.log("created reels",data)

        
    } catch (error) {
        console.log("catch error ",error)
        dispatch({type:CREATE_REELS_FAILUER,payload:error})
    }
}

export const getAllReels=()=>async (dispatch)=>{
    dispatch({type:GET_ALL_REELS_REQUEST})
    try {

        const {data} = await api.get("/api/reels")

        dispatch({type:GET_ALL_REELS_SUCCESS,payload:data})

    } catch (error) {
        console.log("catch error ",error)
        dispatch({type:GET_ALL_REELS_FAILUER,payload:error})
    }
}

export const getUsersReels=(userId)=>async (dispatch)=>{
    dispatch({type:GET_USERS_REEL_REQUEST})
    try {

        const {data} = await api.get(`/api/reels/user/${userId}`)

        dispatch({type:GET_USERS_REEL_SUCCESS,payload:data})

    } catch (error) {
        console.log("catch error ",error)
        dispatch({type:GET_USERS_REEL_FAILUER,payload:error})
    }
}

export const likeReels=(reelId)=>async (dispatch)=>{
    dispatch({type:LIKE_REELS_REQUEST})
    try {

        const {data} = await api.put(`/api/reels/like/${reelId}`)

        dispatch({type:LIKE_REELS_SUCCESS,payload:data})

    } catch (error) {

        console.log("catch error ",error)
        dispatch({type:LIKE_REELS_FAILUER,payload:error})
    }
}

export const savePost=(postId)=>async (dispatch)=>{
    dispatch({type:SAVE_POST_REQUEST})
    try {

        const {data} = await api.put(`/api/posts/${postId}/save`)

        dispatch({type:SAVE_POST_SUCCESS,payload:data})
        
    } catch (error) {
        console.log("catch error ",error)
        dispatch({type:SAVE_POST_FAILUER,payload:error})
    }
}