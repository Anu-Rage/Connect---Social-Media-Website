import { Avatar, Card, CardActions, CardContent, CardHeader, Divider, IconButton, Typography } from "@mui/material";
import React from "react";
import { useDispatch, useSelector } from "react-redux";
import MoreVertIcon from "@mui/icons-material/MoreVert";
import BookmarkBorderIcon from '@mui/icons-material/BookmarkBorder';
import BookmarkIcon from '@mui/icons-material/Bookmark';
import ChatBubbleOutlineIcon from "@mui/icons-material/ChatBubbleOutline";
import FavoriteBorderIcon from "@mui/icons-material/FavoriteBorder";
import FavoriteIcon from "@mui/icons-material/Favorite";
import ShareIcon from "@mui/icons-material/Share";
import { createComment, createCommentReels } from "../../Redux/Comment/comment.action";
import {likeReels, savePost } from "../../Redux/Reels/reels.acton";
import { pink } from "@mui/material/colors";

//used in the profile section
const UsersReelCard = ({ reel }) => {
  const [showComment, setShowComment] = React.useState(false);
  const dispatch = useDispatch();

  const handleCreateComment = (content) => {
    dispatch(createCommentReels({ reelId: reel?.id, data: { content } }));
  };

  const handlePostLike=()=>{
dispatch(likeReels(reel?.id))
  }

  const handleSavePost=()=>{
    dispatch(savePost(reel?.id))
  }
  const {auth} = useSelector(store => store)
  return (
    <div>
    <Card className="w-[15rem] px-2">
       <CardHeader
      className=""
        avatar={
          <Avatar src={auth?.user?.image}
          sx={{ bgcolor:"#212534",color:"rgb(88,199,250)" }} aria-label="recipe">
           
          </Avatar>
        }
        action={
          <IconButton color="primary" aria-label="settings">
            <MoreVertIcon />
          </IconButton>
        }
        title={reel?.user?.firstName + " " + reel?.user?.lastName}
        subheader={
          "@" +
          reel?.user?.firstName.toLowerCase() +
          "_" +
          reel?.user?.lastName.toLowerCase()
        }
      />
      <video 
        className="w-full h-full "
        src={reel.video}
        controls
      />
       <CardContent>
        <Typography variant="body2" color="primary">
          {reel?.title}
          {/* xxxxxxxxxxxxxxxxxx */}
        </Typography>
      </CardContent>

      <CardActions className="flex justify-between" disableSpacing>
        <div>
           <IconButton color="primary" onClick={handlePostLike} aria-label="add to favorites">
          {reel?.likedByRequser ? (
            <FavoriteIcon  sx={{ color: pink[500] }} />
          ) : (
            <FavoriteBorderIcon />
          )}
        </IconButton>
        <IconButton color="primary" aria-label="share">
          <ShareIcon />
        </IconButton>
        <IconButton color="primary" onClick={() => setShowComment(!showComment)}>
          <ChatBubbleOutlineIcon />
        </IconButton>
        </div>
        <div>
          <IconButton color="primary" onClick={handleSavePost}>
            
            {reel?.savedByRequser? <BookmarkIcon/>: <BookmarkBorderIcon/>}
            
          </IconButton>
        </div>
       
      </CardActions>
      {showComment && (
        <section>
          <div className="flex items-center space-x-5 mx-3 my-5">
            <Avatar sx={{bgcolor:"#212534",color:"rgb(88,199,250)"}}/>
            <input
              onKeyPress={(e) => {
                console.log("e", e.target.value);
                if (e.key === "Enter") {
                  console.log("--------");
                  handleCreateComment(e.target.value);
                }
              }}
              className="w-full outline-none bg-transparent border border-[#3b4054] rounded-full px-5 py-2"
              type="text"
              placeholder="write your comment..."
            />
          </div>
          <Divider />
          <div className="mx-3 space-y-2 my-5 text-xs">
            {reel?.comments?.map((comment) => (
              <div className="flex justify-between items-center">
                <div className="flex items-center space-x-5">
                  <Avatar
                    sx={{ height: "2rem", width: "2rem", fontSize: ".8rem",bgcolor:"#212534",color:"rgb(88,199,250)" }}
                  >
                    {comment.user.firstName[0]}
                  </Avatar>
                  <p>{comment.content}</p>
                </div>
                <div>
                  <IconButton color="primary">
                    <FavoriteBorderIcon sx={{ fontSize: "1rem" }} />
                  </IconButton>
                </div>
              </div>
            ))}
          </div>
        </section>
      )}
    </Card>
   
    </div>
  );
};

export default UsersReelCard;
