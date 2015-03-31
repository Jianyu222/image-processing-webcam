import static org.bytedeco.javacpp.opencv_core.cvReleaseImage;
import static org.bytedeco.javacpp.opencv_highgui.cvDestroyWindow;
import static org.bytedeco.javacpp.opencv_highgui.cvLoadImage;
import static org.bytedeco.javacpp.opencv_highgui.cvNamedWindow;
import static org.bytedeco.javacpp.opencv_highgui.cvShowImage;
import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.opencv.core.*;
import org.opencv.highgui.Highgui;        
import org.opencv.highgui.VideoCapture;     

public class VideoCap {
    public static void main (String args[]){
    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    	VideoCapture camera = new VideoCapture(0);
    	
    	if(!camera.isOpened()){
    		System.out.println("Error");
    	}
    	else {
    		Mat frame = new Mat();
    	    while(true){
    	    	if (camera.read(frame)){
    	    		System.out.println("Frame Obtained");
    	    		System.out.println("Captured Frame Width " + 
    	    		frame.width() + " Height " + frame.height());
    	    		Highgui.imwrite("camera.jpg", frame);
    	    		System.out.println("OK");
    	    		break;
    	    	}
    	    }	
    	}
    	camera.release();
    	
    	 IplImage srcImg=cvLoadImage("E:\\TestJavacv\\Test\\camera.jpg");  
    	    if (srcImg !=null) {  
    	        cvNamedWindow("test0.8");  
    	        cvShowImage("test0.8",srcImg);  
    	        cvWaitKey(0);  
    	        cvReleaseImage(srcImg);  
    	        cvDestroyWindow("test0.8");   
    	    }  
    }
}   
