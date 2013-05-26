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

JNIEXPORT jint JNICALL Java_HelloWorld_testArraySum
       (JNIEnv* env, jobject obj, jintArray arr) {
  int i;
  jint sum = 0;
  jsize len = (*env)->GetArrayLength(env, arr);
  jboolean iscopy;
  jint* tab = (*env)->GetIntArrayElements(env, arr, &iscopy);
  for (i = 0; i < len ; i++) sum += tab[i];
  if (iscopy == JNI_TRUE) (*env)->ReleaseIntArrayElements(env, arr, tab, JNI_ABORT);
  return sum;
}
