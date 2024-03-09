import { Avatar, Button } from "@mui/material";
import React from "react";
import { useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";

const VideoCalling = () => {
  const { auth } = useSelector((store) => store);
  const navigate = useNavigate();
  const handleEndCall = () => {
    navigate("/video-call");
  };
  return (
    <div className="h-screen flex flex-col items-center justify-between py-10 border">
      <div>
        <h1 className="font-bold text-4xl">Calling...</h1>
      </div>
      <div className="flex flex-col items-center">
        <Avatar sx={{ width: "15rem", height: "15rem" }} />
        <h1 className="py-2 font-semibold text-2xl">
          {auth?.user?.firstName + " " + auth?.user?.lastName}
        </h1>
      </div>
      <div>
        <Button onClick={handleEndCall} size="large" variant="contained">
          End Call
        </Button>
      </div>
    </div>
  );
};

export default VideoCalling;
