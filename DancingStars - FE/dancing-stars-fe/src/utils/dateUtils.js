export const formatDate = (dateString) => {
    const date = new Date(dateString);
    const formattedDate = date.toLocaleDateString('bg-BG', {
        weekday: 'long',
        day: 'numeric',
        month: 'long',
    });

    return formattedDate.charAt(0).toUpperCase() + formattedDate.slice(1);
};
