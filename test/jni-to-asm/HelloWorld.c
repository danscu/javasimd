#include "HelloWorld.h"
#include <stdlib.h>

/*
 * Class:     HelloWorld
 * Method:    testSum
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_HelloWorld_testSum
  (JNIEnv *env, jobject thisobj, jint arg0)
{
	jint i;
	jint sum = 0;
	for (i = 0; i < arg0; i++)
		sum += i;
	return sum;
}

JNIEXPORT void JNICALL Java_HelloWorld_printArray
       (JNIEnv* env, jclass obj, jintArray arr) {
  int i;
  jsize len = (*env)->GetArrayLength(env, arr);
  printf("int[] : [");
  if (len > 0) {
    jboolean iscopy;
    jint* tab = (*env)->GetIntArrayElements(env, arr, &iscopy);
    for (i = 0; i < len ; i++) printf(" %d", (int)tab[i]);
    if (iscopy == JNI_TRUE) (*env)->ReleaseIntArrayElements(env, arr, tab, JNI_ABORT);
  }
  printf(" ]\n"); fflush(stdout);
}
