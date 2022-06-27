/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
C#, VB, Perl, Swift, Prolog, Javascript, Pascal, HTML, CSS, JS
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

/* NOTE: scanf does not allow reading strings that contain spaces. For that case,
 * both the song name and the artist name need to be added without a space or by 
 * replacing the spaces with the hyphen (_). To read strings with spaces, you need
 * to include C ++ language reserved words.*/

 /*Libraries:
    stdio: Includes the functions, constants and macros from the standard input / output library.
    stdlib: Contains the prototypes of C functions for dynamic memory management, process control and others.
    string: Part of the STL related to string containers; a generalization of alphanumeric strings to hold strings of objects.
    math: Contains the prototypes of the functions and other definitions for the use and manipulation of mathematical functions.
  */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

//The linked list is created that will store the songs with each of their attributes.
typedef struct Playlist
{
  char song_name[50], song_artist[50];
  int song_duration, song_id;
  struct Playlist *next_song, *previous_song;
} Playlist_type;

typedef Playlist_type *Playlist_pointer;
typedef Playlist_type *Song_list;

//Declaration of the variables to be used in the program
char playlist_name[50];
Song_list node_head = NULL;
int number_id;
int value_option, vsong_duration, id_delete, id_song1, id_song2;
char vsong_name[50], vsong_artist[50], search[50];


/* Declaration of the functions to be used. *list refers to the list where the songs will be stored */
void add_song (Song_list * list, char name[50], char artist[50],
	       int duration);
void delete_song (Song_list * list, int id_delete);
void search_song (Song_list * list, char search_value[50]);
void print_playlist (Song_list * list);
void random_song (Song_list * list);
void shuffle_playlist (Song_list * list);
void save_playlist (Song_list * list);
void swap_song (Song_list * list, int id_song1, int id_song2);
void load_playlist ();
void option_menu ();

void
main ()
{
  option_menu ();		//Load the menu option
}

/*Option_menu function: It houses all the options that the user can choose when creating 
the Playlist. It receives through value_option the integer that corresponds to each option 
and the respective function is called.*/
void
option_menu ()
{
  //Show all the option to choose.
  printf ("My Music Playlist\n");
  printf ("--------------------------------------------------------------\n");
  printf ("Option Menu\n");
  printf
    ("1. Create a playlist.\n2. Add a new song.\n3. Play the playlist.\n4. Search a song.\n5. Delete a song.\n6. Swap the position of two Songs.\n7. Play a random Song from the list.\n8. Shuffle the order of the Playlist.\n9. Calculate the duration of the Playlist.\n10. Save the Playlist.\n11. Load the Playlist\n");
  printf ("Insert the number that corresponds to the desired option:");
  scanf ("%d", &value_option);
  value_option = (int) value_option;
  switch (value_option)
    {
      //The name of the new Playlist is saved
    case 1:
      printf ("Write the name of the new Playlist:");
      scanf ("%s", &playlist_name);
      option_menu ();
      break;
      /*The name, artist and song duration are read in seconds and then
         the add_song function is called and the data is saved. */
    case 2:
      printf ("Write the name of the song:");
      scanf ("%s", &vsong_name);
      printf ("Write the name of the artist:");
      scanf ("%s", &vsong_artist);
      printf ("Write the duration of the song (in seconds):");
      scanf ("%d", &vsong_duration);
      add_song (&node_head, vsong_name, vsong_artist, vsong_duration);
      option_menu ();
      break;
      /*The print_playlist function is called to display the Playlist that was currently
         stored in the linked list. */
    case 3:
      printf ("Playlist Name: %s\n", playlist_name);
      printf ("#\t\t\tSong\t\t\tArtist\t\t\tDuration (mins/secs) \n");
      print_playlist (&node_head);
      option_menu ();
      break;
    case 4:
      /*The search_song function is called to search for a song by its id */
      printf ("Write the name of the song or artist to search:");
      scanf ("%s", &search);
      search_song (&node_head, search);
      option_menu ();
      break;
    case 5:
      //The delete_song function delete a song by its id
      printf ("Write the id of the song to delete:");
      scanf ("%d", &id_delete);
      delete_song (&node_head, id_delete);
      option_menu ();
      break;
    case 6:
      //The swap_song function swap the position of two songs by entering their id
      printf ("Write the id of the first song to swap:");
      scanf ("%d", &id_song1);
      printf ("Write the id of the second song to swap:");
      scanf ("%d", &id_song2);
       printf ("The swap song is:\n");
    printf ("#\t\t\tSong\t\t\tArtist\t\t\tDuration (mins/secs) \n");
      swap_song (&node_head, id_song1, id_song2);
      option_menu ();
      break;
    case 7:
      //The random_song function displays a song that is randomly generated on the screen.
       printf ("The random song is:\n");
    printf ("#\t\t\tSong\t\t\tArtist\t\t\tDuration (mins/secs) \n");
      random_song (&node_head);
      option_menu ();
      break;
    case 8:
      //The shuffle_playlist function gets the number of songs added to the Playlist and then shuffles it randomly
      printf ("The shuffle playlist is:\n");
    printf ("#\t\t\tSong\t\t\tArtist\t\t\tDuration (mins/secs) \n");
      shuffle_playlist (&node_head);
      option_menu ();
      break;
    case 9:
      //The duration_playlist function shows the total of hours, minutes and seconds of the Playlist.
      duration_playlist (&node_head);
      option_menu ();
      break;
    case 10:
      //The save_playlist function save the elements of the Playlist in a text file
      save_playlist (&node_head);
      option_menu ();
      break;
    case 11:
      //The load_playlist function load the playlist (if exist) of the text file
      load_playlist ();
      option_menu ();
      break;
    default:
      printf ("Error! operator is not correct.\n");

      option_menu ();
    }
}

void
load_playlist ()
{
  /*Function that uses an object of type FILE to be able to load the Playlist on the screen
     (if it exists) by going through the file with a WHILE structure. */
  FILE *playlist_file = fopen ("Playlist.txt", "rt");
  if (playlist_file == NULL)
    exit (1);
  char line[100];
  fgets (line, 100, playlist_file);
  while (!feof (playlist_file))
    {
      printf ("%s", playlist_file);
      fgets (playlist_file, 100, playlist_file);
    }
  fclose (playlist_file);
  getch ();

}

void
save_playlist (Song_list * list)
{
    /*Function that receives as a parameter a pointer of the type list that will be used
    to go through all the values of the list and save them in a text file. To do this, 
    first a FILE type object is created to generate the text file and then the list is 
    scrolled to save the songs in the Playlist
    If the file cannot be created, send the error message. To save the song id and duration,
    the number and duration arrangements are created.
   fputs: Save a text string to file.
    sprintf: That is used to send formatted output to the string.
    */
  Playlist_pointer node_head = *list;
  printf ("\n\n\nSave the information.");
  FILE *file_playlist = fopen ("Playlist.txt", "wb");
  if (file_playlist == NULL)
    {
      printf ("\n\n\nError.");
      return;
    }
  char number[3], duration[5];
  fputs ("Playlist name: ", file_playlist);
  fputs (playlist_name, file_playlist);
  fputs ("\n", file_playlist);
  fputs ("#\t\t\tSong\t\t\tArtist\t\t\tDuration (mins/secs) \n", file_playlist);
  while (node_head != NULL)
    {
      sprintf (number, "%d", node_head->song_id);
      sprintf (duration, "%d", node_head->song_duration);
      fputs (number, file_playlist);
      fputs ("\t\t\t", file_playlist);
      fputs (node_head->song_name, file_playlist);
      fputs ("\t\t\t",file_playlist);
      fputs (node_head->song_artist, file_playlist);
      fputs ("\t\t\t", file_playlist);
      fputs (duration, file_playlist);
      fputs ("\n", file_playlist);

      node_head = node_head->next_song;
    }
}

void
shuffle_playlist (Song_list * list)
{
    /*To shuffle the songs stored in the playlist, the sdran function is first used to help generate 
    the random numbers. Then, the nodes to be used are created.*/
  srand (time (NULL));
  Playlist_pointer current_list;
  Playlist_pointer count = *list;
  Playlist_pointer aux_song =
    (Playlist_pointer) malloc (sizeof (Playlist_type));
//Get the number of items available in the linked list
  int id, random_id;
  while (count != NULL)
    {
      id = count->song_id;
      count = count->next_song;
    }

  int control_id[id];
/*With the help of the FOR loop, the instructions that are inside are executed the number
of times, based on the total number of elements that the list has.
Then, a random number is generated which will be verified that it is not repeated (using the
checkrep function) and is stored in an array. This value will be used to compare it with that
of the list to be traversed and if it exists, the value will be stored in a new temporary pointer
and the list will be restarted until all the matching values are found.
rand(), returns a pseudo-random number in the range of 0 to RAND_MAX.
memcpy() copies n characters from memory area src to memory area dest.*/
  for (int i = 0; i < id; i++)
    {
      do
	random_id = rand () % id + 1;
      while (checkrep (random_id, id, control_id) == 1);
      control_id[i] = random_id;
      current_list = *list;
      aux_song = *list;
      while (current_list != NULL)
	{
	  if (current_list->song_id == control_id[i])
	    {
	      aux_song->song_id = current_list->song_id;
	      aux_song->song_duration = current_list->song_duration;
	      memcpy (aux_song->song_name, current_list->song_name, 50);
	      memcpy (aux_song->song_artist, current_list->song_artist, 50);
	      printf ("%d\t\t\t%s\t\t\t%s\t\t\t%d\n", aux_song->song_id,
		      aux_song->song_name, aux_song->song_artist,
		      aux_song->song_duration);
	    }
	  current_list = current_list->next_song;
	  aux_song = aux_song->next_song;
	}

    }
  current_list = aux_song;
}

void
random_song (Song_list * list)	
{
    /*In the random_song function, it is first sought to know the number of elements
    that the linked list has, after obtaining this value, a random number is generated with the rand () 
    function and from this value the corresponding song is searched within the node with that ID
    to be displayed on the screen.*/
  Playlist_pointer current_list = *list;
  Playlist_pointer count = *list;
  int id, random_id = 0;
  while (count != NULL)
    {
      id = count->song_id;
      count = count->next_song;
    }
  random_id = rand () % id + 1;
  while (current_list)
    {
      if (current_list->song_id == random_id)
	{
	  printf ("%d\t\t\t%s\t\t\t%s\t\t\t%d\n", current_list->song_id, current_list->song_name, current_list->song_artist, current_list->song_duration);	//Imprimimos el valor del nodo
	  break;
	}
      else
	current_list = current_list->next_song;
    }


}

void
add_song (Song_list * list, char name[50], char artist[50], int duration)	
{
  Playlist_pointer new_song, current_song;
  number_id++;
  /* Create a new node with our attributes and */
  new_song = (Playlist_pointer) malloc (sizeof (Playlist_type));
  new_song->song_id = number_id;
  strcpy (new_song->song_name, name);	//Assign the value entered on the screen to that
  strcpy (new_song->song_artist, artist);
  new_song->song_duration = duration;

  /* We place current in the first position of the list */
  current_song = *list;
  if (current_song)
    while (current_song->previous_song)
      current_song = current_song->previous_song;
  /* If the list is empty the first member is greater than the new one */
  if (!current_song || current_song->song_id > number_id)
    {
      /*We add the list below the new node */
      new_song->next_song = current_song;
      new_song->previous_song = NULL;
      if (current_song)
	current_song->previous_song = new_song;
      if (!*list)
	*list = new_song;
    }
  else
    {
      /* We advance to the last element or until the next one has
          a higher value */
      while (current_song->next_song
	     && current_song->next_song->song_id <= number_id)
	current_song = current_song->next_song;
      /* We insert the new node after the previous node*/
      new_song->next_song = current_song->next_song;
      current_song->next_song = new_song;
      new_song->previous_song = current_song;
      if (new_song->next_song)
	new_song->next_song->previous_song = new_song;
    }
}

void
delete_song (Song_list * list, int id_delete)
{
  Playlist_pointer actual_list;

  /* Search the node with value id_delete */
  actual_list = *list;
  while (actual_list && actual_list->song_id < id_delete)
    actual_list = actual_list->next_song;
  while (actual_list && actual_list->song_id > id_delete)
    actual_list = actual_list->previous_song;

  /* If id_delete value isn't in the list */
  if (!actual_list || actual_list->song_id != id_delete)
    return;

  /* Delete the node */
  /* If list points to the node we want to delete, point to another */
  if (actual_list == *list)
    if (actual_list->previous_song)
      *list = actual_list->previous_song;
    else
      *list = actual_list->next_song;

  if (actual_list->previous_song)	/* not's the first element */
    actual_list->previous_song->next_song = actual_list->next_song;
  if (actual_list->next_song)	/* not's the last node */
    actual_list->next_song->previous_song = actual_list->previous_song;
  free (actual_list);		//function that delete the node.
}

void
search_song (Song_list * list, char search_value[50])
{
  Playlist_pointer node_head;
  node_head = *list;
  if (node_head != NULL)
    {
      while (node_head != NULL)
	{
	  if ((strcmp (node_head->song_name, search_value) == 0)
	      || (strcmp (node_head->song_artist, search_value) == 0))
	    {
	      printf ("%d\t\t\t%s\t\t\t%s\t\t\t%d\n", node_head->song_id, node_head->song_name, node_head->song_artist, node_head->song_duration);	
	    }
	  node_head = node_head->next_song;
	}
    }
  else
    {
      printf ("%s\n", "The song does not exist.");
      
    }
}

void
swap_song (Song_list * list, int id_song1, int id_song2)	
{
    /*In this function three additional nodes are created (first, second and aux), 
    which will be used to save the songs that will be exchanged (if they exist in the list)*/
  Playlist_pointer node_head, node_head2;
  Playlist_pointer first_song =
    (Playlist_pointer) malloc (sizeof (Playlist_type));
  Playlist_pointer second_song =
    (Playlist_pointer) malloc (sizeof (Playlist_type));
  Playlist_pointer aux_song =
    (Playlist_pointer) malloc (sizeof (Playlist_type));

  node_head = *list;
  node_head2 = *list;
  aux_song = *list;
  /*As long as the node has values, it will be traversed until it finds the first song.
  If found, a copy of the node will be saved in first and second.*/
  if (node_head != NULL)
    {
      while (node_head != NULL)
	{
	  if (node_head->song_id == id_song1)
	    {
	      first_song->song_id = node_head->song_id;
	      first_song->song_duration = node_head->song_duration;
	      memcpy (first_song->song_name, node_head->song_name, 50);
	      memcpy (first_song->song_artist, node_head->song_artist, 50);
	    }
	  if (node_head->song_id == id_song2)
	    {
	      second_song->song_id = node_head->song_id;
	      second_song->song_duration = node_head->song_duration;
	      memcpy (second_song->song_name, node_head->song_name, 50);
	      memcpy (second_song->song_artist, node_head->song_artist, 50);
	    }
	  node_head = node_head->next_song;
	}
    }
  else
    {
      printf ("The song does not exist");
    }
    /*If the two songs exist, we proceed to go through the list again
    until we find them and be able to exchange values*/
  if ((first_song != NULL) && (second_song != NULL))
    {
      if (node_head2 != NULL)
	{
	  while (node_head2 != NULL)
	    {
	      if (node_head2->song_id == first_song->song_id)
		{
		  aux_song->song_id = second_song->song_id;
		  aux_song->song_duration = second_song->song_duration;
		  memcpy (aux_song->song_name, second_song->song_name, 50);
		  memcpy (aux_song->song_artist, second_song->song_artist,
			  50);
		}
	      else
		{
		  if (node_head2->song_id == second_song->song_id)
		    {
		      aux_song->song_id = first_song->song_id;
		      aux_song->song_duration = first_song->song_duration;
		      memcpy (aux_song->song_name, first_song->song_name, 50);
		      memcpy (aux_song->song_artist, first_song->song_artist,
			      50);
		    }
		  else
		    {
		      aux_song->song_id = node_head2->song_id;
		      aux_song->song_duration = node_head2->song_duration;
		      memcpy (aux_song->song_name, node_head2->song_name, 50);
		      memcpy (aux_song->song_artist, node_head2->song_artist,
			      50);
		    }
		}
	      node_head2 = node_head2->next_song;
	      aux_song = aux_song->next_song;
	    }
	  node_head2 = aux_song;
	}
    }


}

void
print_playlist (Song_list * list)	
{
    //Loop through the node to print the values that are inside
  Playlist_pointer node_head;
  node_head = *list;
  while (node_head != NULL)
    {				//As long as head is not NULL
      printf ("%d\t\t\t%s\t\t\t%s\t\t\t%d\n", node_head->song_id, node_head->song_name, node_head->song_artist, node_head->song_duration);	//We print the value of the node
      node_head = node_head->next_song;	//We go to the next node
    }

}

void
duration_playlist (Song_list * list)
{
    //Function that converts duration in seconds into hours, minutes and seconds
  Playlist_pointer current_list = *list;
  int second = 0;
  float hour2, minute2, sec2;
  int hour, minute, sec;
  while (current_list != NULL)
    {
      second += current_list->song_duration;
      current_list = current_list->next_song;

    }
  hour = (int) (second / 3600);
  minute = (int) ((second - hour * 3600) / 60);
  sec = (int) second - (hour * 3600 + minute * 60);
  printf ("The actual list has a duration of %s or %d:%d:%d\n", second, hour,
	  minute, sec);
}

int
checkrep (int random, int id, int control[])
{
    //The checkrep function allows you to identify if there are any repeated values among the values obtained randomly.
  for (int i = 0; i < id; i++)
    {
      if (random == control[i])
	{
	  return 1;
	}
    }
  return 0;
}
